package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.ProductPackage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author marcelwidmer
 */
public interface ProductPackageRepository extends JpaRepository<ProductPackage,  Integer> {

}
