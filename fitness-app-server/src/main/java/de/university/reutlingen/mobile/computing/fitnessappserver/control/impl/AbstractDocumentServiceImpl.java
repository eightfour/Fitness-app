package de.university.reutlingen.mobile.computing.fitnessappserver.control.impl;

import de.university.reutlingen.mobile.computing.fitnessappserver.control.AbstractDocumentService;
import de.university.reutlingen.mobile.computing.fitnessappserver.model.AbstractDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AbstractDocumentServiceImpl<D extends AbstractDocument<P>, P extends Serializable, R extends ReactiveMongoRepository<D,
        P>> implements AbstractDocumentService<D, P, R> {

    @Override
    public final Mono<D> save ( D document ) {
        if (document.isNew ()) {
            document.setId ( generateId () );
        }

        return getRepository ().save ( document );
    }

    protected abstract void doSave ( D document );

}
