package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.rest.dao.OrgDao;
import se331.rest.entity.Org;

@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    OrgDao orgDao;

    @Override
    public Integer getOrgSize() {
        return orgDao.getOrgSize();
    }

    @Override
    public Page<Org> getOrgs(Integer pageSize, Integer page) {
        return orgDao.getOrgs(pageSize, page);
    }

    @Override
    public Org getOrg(Long id) {
        return orgDao.getOrg(id);
    }

    @Override
    public Org save(Org org) {

        return orgDao.save(org);

    }
}

