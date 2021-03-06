package cybersoft.javabackend.java16giranhan.role.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giranhan.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giranhan.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRole> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
	GiraRole update(UUID id, @Valid GiraRoleDTO dto);
	GiraRole findById(String id);
}
