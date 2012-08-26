// Place your Spring DSL code here
beans = {
    customAuthenticationProvider(CustomAuthenticationProvider) {
        daoAuthenticationProvider = ref('daoAuthenticationProvider')
    }
}