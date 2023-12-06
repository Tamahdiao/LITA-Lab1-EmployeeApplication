package com.example.litalab1employeeapplication.Controller;

import com.example.litalab1employeeapplication.entity.Contribution;
import com.example.litalab1employeeapplication.entity.Employee;
import com.example.litalab1employeeapplication.repository.ContributionRepository;
import com.example.litalab1employeeapplication.service.EmployeeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contributions")
public class ContributionController {
    private final ContributionRepository repository;

    ContributionController(ContributionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    Contribution addContribution(@RequestBody Contribution contribution) {
        return repository.save(contribution);
    }


    @GetMapping("/employee/{username}")
    // @PreAuthorize("principal.username == #username")
    public List<Contribution> findUserByUsername(@PathVariable String username) {
       /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EmployeeDetails employeeConnected = (EmployeeDetails) auth.getPrincipal();
        if (employeeConnected.getUsername() == username) {
            return repository.findContributionByEmployee_Username(username);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }*/
          return repository.findContributionByEmployee_Username(username);
    }

    @PutMapping("/update/{id}")
        //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    Contribution updateContribution(@RequestBody Contribution newContribution, @PathVariable Long id) {

        /*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EmployeeDetails employeeConnected = (EmployeeDetails) auth.getPrincipal();
        if (employeeConnected.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return repository.findById(id)
                    .map(contribution -> {
                        contribution.setAmount(newContribution.getAmount());
                        repository.save(contribution);
                        return new ResponseStatusException(HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        newContribution.setId(id);
                         repository.save(newContribution);
                        return new ResponseStatusException(HttpStatus.OK);
                    });
        }
        else{
            return  new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
         */

        return repository.findById(id)
                .map(contribution -> {
                    contribution.setAmount(newContribution.getAmount());
                    return repository.save(contribution);
                })
                .orElseGet(() -> {
                    newContribution.setId(id);
                    return repository.save(newContribution);
                });
    }

}
