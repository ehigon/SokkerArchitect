package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.exception.LoginError

enum class LoginErrorMapping(
    val loginError : LoginError, val resource: Int
) {
    BAD_PASSWORD(LoginError.BAD_PASSWORD, R.string.bad_password),
    NO_TEAM(LoginError.NO_TEAM, R.string.no_team),
    BANNED(LoginError.BANNED, R.string.banned),
    BANKRUPT(LoginError.BANKRUPT, R.string.bankrupt),
    BLACKLISTED_IP(LoginError.BLACKLISTED_IP, R.string.blacklisted_ip),
    UNKNOWN(LoginError.UNKNOWN, R.string.unknown),
    NO_XMLSESSID(LoginError.NO_XMLSESSID, R.string.no_xmlsessid),
    NO_COOKIES(LoginError.NO_COOKIES, R.string.no_cookies),
    NO_TEAM_ID(LoginError.NO_TEAM_ID, R.string.no_team_id);

    companion object {
        fun fromLoginError(loginError: LoginError): LoginErrorMapping {
            val error = entries.filter { it.loginError == loginError }
            if (error.isEmpty()) {
                return UNKNOWN
            }
            return error[0]
        }
    }

}