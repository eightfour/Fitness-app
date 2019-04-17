package de.university.reutlingen.mobile.computing.fitnessappserver.control;

import de.university.reutlingen.mobile.computing.fitnessappserver.model.AbstractDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * Base interface for all control services.
 * @param <D> type of the document
 * @param <R> type of repository
 */
public interface AbstractDocumentService<D extends AbstractDocument, P extends Serializable,R extends ReactiveMongoRepository<D, P>> {

    /**
     * Save the given document and return the result
     * @param document
     * @return
     */
    Mono<D> save ( D document);

    R getRepository();

    P generateId();
}
