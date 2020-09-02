package br.com.healthtrack.platform.service;

import br.com.healthtrack.platform.security.HospitalUserDetails;

public abstract class HospitalUserService extends UserBasedApiService {

    public Integer getHospitalId() {
        Object principal = getPrincipalFromSecurityContext();
        if (principal instanceof HospitalUserDetails) {
            return ((HospitalUserDetails) principal).getCredencial().getHospital().getCodigo();
        } else {
            throw new RuntimeException("Logged in user that cannot matches a Hospital user trying to" +
                    " consumes HospitalUserService");
        }
    }
}
