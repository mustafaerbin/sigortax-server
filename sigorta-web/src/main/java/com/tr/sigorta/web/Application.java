package com.tr.sigorta.web;

import com.tr.nebula.web.WebApplication;
import com.tr.sigorta.web.cli.InitialCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Mustafa Erbin on 03/03/2017.
 */
@ComponentScan({"com.tr.sigorta", "com.tr.nebula"})
@EnableJpaRepositories(basePackages = {"com.tr.sigorta.repository", "com.tr.nebula.security.db.repository"})
@EntityScan(basePackages = {"com.tr.sigorta.domain",
        "com.tr.nebula.security.db.domain"})
public class Application extends WebApplication {

    @Autowired
    InitialCommand initialCommand;

    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Override
    public void init(ApplicationArguments applicationArguments) {
        initialCommand.run();
    }
}
