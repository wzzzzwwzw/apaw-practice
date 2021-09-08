package es.upm.miw.apaw_practice.adapters.mongodb.shop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.daos.TagRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.TagEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.shop.Tag;
import es.upm.miw.apaw_practice.domain.persistence_ports.shop.TagPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("tagPersistence")
public class TagPersistenceMongodb implements TagPersistence {

    private TagRepository tagRepository;

    @Autowired
    public TagPersistenceMongodb(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Stream< Tag > readAll() {
        return this.tagRepository.findAll().stream()
                .map(TagEntity::toTag);
    }

    @Override
    public Tag readById(String id) {
        return this.tagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(" Tag id: " + id))
                .toTag();
    }

    @Override
    public void delete(String id) {
        this.tagRepository.deleteById(id);
    }
}
