package hebbar.brs.controller;

import hebbar.brs.DTO.AgencyDto;
import hebbar.brs.DTO.BusDto;
import hebbar.brs.entities.Agency;
import hebbar.brs.entities.Bus;
import hebbar.brs.models.AgencyModel;
import hebbar.brs.models.BusModel;
import hebbar.brs.models.ClaimsResolver;
import hebbar.brs.services.JwtUtil;
import hebbar.brs.services.RoleAccessService;
import hebbar.brs.services.admin.AdminService;
import hebbar.brs.services.exception.IllegalValueException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleAccessService roleAccessService;

    @PostMapping("/add_agency")
    public ResponseEntity<AgencyDto> createAgency(@RequestBody AgencyModel agencyModel,
                               @RequestHeader("Authorization") final String bearerToken) {
        if (bearerToken.startsWith("Bearer ")) {
            String jwtToken = bearerToken.substring(7);
            Map<String, Object> tokenClaim = new HashMap<>();
            Object role;
            Function<Claims, Object> claimsFunc = new Function<Claims, Object>() {
                @Override
                public Object apply(Claims claims) {
                    return claims.get("role");
                }
            };
            role = jwtUtil.extractClaim(jwtToken, claimsFunc);
            Long roles = Long.parseLong(role.toString());

            if (roleAccessService.isAdmin(roles)) {
                Agency agency = adminService.addAgency(agencyModel);
                List<Agency> allAgencies = adminService.getAllAgency();
                AgencyDto agencyDto = new AgencyDto()
                        .setAgencies(allAgencies)
                        .setStatus(HttpStatus.OK.toString())
                        .setDescription("ACCEPTED");
                return new ResponseEntity<>(agencyDto, HttpStatus.OK);
            } else {
                throw new IllegalValueException("Operation not allowed");
            }
        } else {
            throw new IllegalValueException("Please provide token in the header");
        }
    }

    @GetMapping("/getAllAgency")
    public ResponseEntity<AgencyDto> getAllAgencies(@PathVariable final String email) {
        return null;
    }

    @PostMapping("/add_bus")
    public ResponseEntity<BusDto> addBusesToAgency(@RequestBody BusModel busModel) {
        Bus bus = adminService.addNewBusToAgency(busModel);
        List<Bus> buses = adminService.getAllBusInAgency();
        BusDto busDto = new BusDto()
                .setHttpStatus(HttpStatus.OK)
                .setDescription("ACCEPTED")
                .setBuses(buses);
        return new ResponseEntity<>(busDto, HttpStatus.OK);
    }
}

