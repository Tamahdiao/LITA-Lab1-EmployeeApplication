package com.example.litalab1employeeapplication.Controller;

import com.example.litalab1employeeapplication.entity.Contribution;
import com.example.litalab1employeeapplication.repository.ContributionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContController {
    private final ContributionRepository repository;

    ContController(ContributionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contributions/all")
    public String getAllContributions(Model model) {
        try {
            List<Contribution> contributionList = new ArrayList<Contribution>();
            repository.findAll().forEach(contributionList::add);

            model.addAttribute("contributionList", contributionList);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "contributionsList";
    }
}
