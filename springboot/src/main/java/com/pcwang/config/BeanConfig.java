package com.pcwang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BeanConfig {

    @Autowired
    public BeanConfig(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        Set<String> names = args.getOptionNames();

        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }

}
