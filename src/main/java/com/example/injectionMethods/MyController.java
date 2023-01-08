package com.example.injectionMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MyController {
    //Field injection
//    @Autowired
//    private FirstClass firstClass;
    // Setter injection
    private SecondClass secondClass;
    private FirstClass firstClass;
    private ThirdClass thirdClass;
    //Consttructor injection

    public MyController(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }
@Autowired
    public MyController(FirstClass firstClass, ThirdClass thirdClass) {
        this.firstClass = firstClass;
        this.thirdClass = thirdClass;
    }

    @GetMapping(path = "/names")
    public String getNameOfClases(){
        return this.firstClass.getName()+ "-"+ this.secondClass.getName()+ "-"+ this.thirdClass.getName();
    }
    // Setter injection
@Autowired
    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

}
