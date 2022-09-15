package se331.rest.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.Org;


public interface OrgDao {
    Integer getOrgSize();
    Page<Org> getOrgs(Integer pageSize, Integer page);
    Org getOrg(Long id);
    Org save(Org event);
}

