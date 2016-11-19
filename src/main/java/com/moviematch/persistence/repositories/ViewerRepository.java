package com.moviematch.persistence.repositories;

import com.moviematch.persistence.pks.ViewerKey;
import com.moviematch.persistence.pojos.Viewer;
import org.springframework.data.repository.CrudRepository;

public interface ViewerRepository extends CrudRepository<Viewer, ViewerKey> {
}
