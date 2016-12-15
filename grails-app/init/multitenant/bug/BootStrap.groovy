package multitenant.bug

class BootStrap {

    def init = { servletContext ->
        // create ROLE_USER
        def roleUser = Role.findAllByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(true)

        // create 2 test users
        def user1 = User.findByUsername("user1") ?: new User(username: "user1", password: "password").save(true)
        def user2 = User.findByUsername("user2") ?: new User(username: "user2", password: "password").save(true)

        // assign user roles
        UserRole.create user1, roleUser
        UserRole.create user2, roleUser
    }

    def destroy = {
    }
}
