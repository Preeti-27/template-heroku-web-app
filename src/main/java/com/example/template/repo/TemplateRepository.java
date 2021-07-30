package com.example.template.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.template.model.Template;
@Component
@Repository
public interface TemplateRepository extends MongoRepository<Template, String> {

}
