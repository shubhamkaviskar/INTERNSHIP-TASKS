package com.Initializer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Initializer.Model.OwnEnterprises;
import com.Initializer.Service.OwnEnterprisesService;
import com.Initializer.Service.DAKRSolutionsService;

@Controller
public class OwnEnterprisesController {

    @Autowired
    private OwnEnterprisesService ownEnterprisesService;

    @Autowired
    private DAKRSolutionsService dakrSolutionsService;

    @GetMapping("/own-enterprises-form")
    public String showOwnEnterprisesForm(Model model) {
        model.addAttribute("ownEnterprises", new OwnEnterprises());
        return "ownEnterprisesForm"; // JSP name for the view
    }

    @PostMapping("/saveOwnEnterprise")
    public String submitOwnEnterpriseForm(OwnEnterprises ownEnterprise) {
        // Set the DAKRSolutions mapping if necessary
        ownEnterprisesService.saveOwnEnterprise(ownEnterprise);
        return "success"; // Redirect to success page
    }
}
