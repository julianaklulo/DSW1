
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'br.ufscar.dc.dsw.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'br.ufscar.dc.dsw.UserRole'
grails.plugin.springsecurity.authority.className = 'br.ufscar.dc.dsw.Role'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
        [pattern: '/oauth',          access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/api/logout',     access: ['isAuthenticated()']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
    [pattern: '/assets/**',      filters: 'none'],
    [pattern: '/**/js/**',       filters: 'none'],
    [pattern: '/**/css/**',      filters: 'none'],
    [pattern: '/**/images/**',   filters: 'none'],
    [pattern: '/**/favicon.ico', filters: 'none'],

    [
            pattern: '/api/**',
            filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
    ],

    [
            pattern: '/rest/**',
            filters: 'restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor'
    ],
    [pattern: '/**',             filters: 'JOINED_FILTERS']
]

//grails.plugin.springsecurity.rest.token.storage.jwt.expiration=5
