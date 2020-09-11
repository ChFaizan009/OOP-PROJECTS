package pk.edu.uog.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pk.edu.uog.datalogs.model.DatabaseTables;

public interface databaseTablesRepository extends JpaRepository<DatabaseTables,Long>{

}
