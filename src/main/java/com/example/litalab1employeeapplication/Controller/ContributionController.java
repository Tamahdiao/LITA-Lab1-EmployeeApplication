package com.example.litalab1employeeapplication.Controller;

import com.example.litalab1employeeapplication.entity.Contribution;
import com.example.litalab1employeeapplication.entity.Employee;
import com.example.litalab1employeeapplication.entity.UserInfo;
import com.example.litalab1employeeapplication.repository.ContributionRepository;
import com.example.litalab1employeeapplication.repository.EmployeeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    public List<Contribution> findUserByUsername(@PathVariable  String username) {
        return repository.findContributionByEmployee_Username(username);
    }
    @PutMapping("/update/{id}")
  //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    Contribution updateContribution(@RequestBody Contribution newContribution, @PathVariable Long id) {

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
