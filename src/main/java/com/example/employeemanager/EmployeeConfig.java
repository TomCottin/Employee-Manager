package com.example.employeemanager;

import java.util.List;

import com.example.employeemanager.models.Employee;
import com.example.employeemanager.repository.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee tom = new Employee(
                null,
                "Tom",
                "tom@epsi.fr",
                "Fullstack Dev",
                "+1 202 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar1.png",
                "45820197-Y"
            );
            Employee maxou = new Employee(
                null,
                "Maxou",
                "maxou@epsi.fr",
                "Osthéopathe",
                "+1 854 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar2.png",
                "45820198-Y"
            );
            Employee sylv = new Employee(
                null,
                "Sylvain",
                "sylvain@epsi.fr",
                "Humouriste",
                "+1 349 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar3.png",
                "45820199-Y"
            );
            Employee liam = new Employee(
                null,
                "Liam",
                "nLiam@epsi.fr",
                "Entrepreneur",
                "+1 978 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar4.png",
                "45820200-Y"
            );
            Employee malo = new Employee(
                null,
                "Malo",
                "maloViennet@epsi.fr",
                "Etudiant",
                "+1 000 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar5.png",
                "45820201-Y"
            );
            Employee adrien = new Employee (
                null,
                "Adrien",
                "adGunz@epsi.fr",
                "Artiste",
                "+1 007 XXX XXXX",
                "https://bootdey.com/img/Content/avatar/avatar6.png",
                "45820202-Y"
            );
            employeeRepository.saveAll(
                List.of(tom, maxou, sylv, liam, malo, adrien)
            );
        };
    }

}