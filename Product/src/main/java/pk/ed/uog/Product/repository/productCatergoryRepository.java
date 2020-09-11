package pk.ed.uog.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pk.ed.uog.Product.model.ProductCategory;

public interface productCatergoryRepository extends JpaRepository<ProductCategory, Long> {

	@Query(value = "select * from TBLPRODUCTCATERGORY where ISACTIVE='Y'", nativeQuery = true)
	public List<ProductCategory> findActive();

	
}
