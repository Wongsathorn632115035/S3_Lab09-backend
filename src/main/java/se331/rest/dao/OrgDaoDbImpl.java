package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Org;
import se331.rest.repository.OrgRepository;

@Repository
@Profile("db")
public class OrgDaoDbImpl implements OrgDao {
    @Autowired
    OrgRepository orgRepository;

    @Override
    public Integer getOrgSize() {
        return Math.toIntExact(orgRepository.count());
    }

    @Override
    public Page<Org> getOrgs(Integer pageSize, Integer page) {
        return orgRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Org getOrg(Long id) {
        return orgRepository.findById(id).orElse(null);
    }

    @Override

    public Org save(Org org) {

        return orgRepository.save(org);

    }
}