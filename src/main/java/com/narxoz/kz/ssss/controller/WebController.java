package com.narxoz.kz.ssss.controller;

import com.narxoz.kz.ssss.model.Phone;
import com.narxoz.kz.ssss.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    PhoneRepository repository;

    @GetMapping("/")
    public String showPhoneList(Model model) {
        List<Phone> Phones = repository.findAll();
        // Check if `param` is not empty
        model.addAttribute("Phones", Phones);
        return "index";
    }

    @PostMapping("/addphone")
    public String createPhone(@ModelAttribute Phone phone) {
        addPhone(phone);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updatePhone(@PathVariable("id") long id, Phone phone) {
        updatePhone(phone);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePhone(@PathVariable("id") long id) {
        deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Phone phone) {
        return "add-phone";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Phone phone = repository.getById(id);
        model.addAttribute("phone", phone);
        return "update-phone";
    }

    private void deleteById(long id) {
        repository.deleteById(id);
    }

    private void addPhone(Phone newPhone) {
        repository.save(newPhone);
    }

    private void updatePhone(Phone updatePhone) {
        Phone oldPhone = repository.getById(updatePhone.getId());

        oldPhone.setName(updatePhone.getName());
        oldPhone.setMarka(updatePhone.getMarka());
        oldPhone.setMemory(updatePhone.getMemory());
        oldPhone.setRam(updatePhone.getRam());
        oldPhone.setCountry(updatePhone.getCountry());
        oldPhone.setPrice(updatePhone.getPrice());
        oldPhone.setDescription(updatePhone.getDescription());
        repository.save(oldPhone);
    }
}