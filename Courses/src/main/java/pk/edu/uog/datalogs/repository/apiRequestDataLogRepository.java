package pk.edu.uog.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pk.edu.uog.datalogs.model.APIRequestDataLog;

public interface apiRequestDataLogRepository extends JpaRepository<APIRequestDataLog,Long>{

}
