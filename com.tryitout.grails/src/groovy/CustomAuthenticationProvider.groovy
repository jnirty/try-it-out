import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.authentication.dao.DaoAuthenticationProvider

class CustomAuthenticationProvider implements AuthenticationProvider
{
    DaoAuthenticationProvider daoAuthenticationProvider

    Authentication authenticate(Authentication authentication)
    {
        println "CustomAuthenticationProvider -> authenticating user..."
        if (authentication instanceof UsernamePasswordAuthenticationToken)
        {
            UsernamePasswordAuthenticationToken token =
                (UsernamePasswordAuthenticationToken) authentication
            String username = token.getPrincipal()
            String password = token.getCredentials()
            println "CustomAuthenticationProvider -> user:${username}, pass: ${password}"
            def canAuthenticate = true
            if (canAuthenticate)
            {
                return daoAuthenticationProvider.authenticate(token)
            }
        }
        return null
    }
    boolean supports(Class<? extends Object> aClass)
    {
        if (aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class))
        {
            return true
        }
        return false
    }
}
