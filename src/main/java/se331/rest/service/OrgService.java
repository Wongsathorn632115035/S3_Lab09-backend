package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Org;

public interface OrgService {
    Integer getOrgSize();

    Page<Org> getOrgs(Integer pageSize, Integer page);

    Org getOrg(Long id);

    Org save(Org event);
}
