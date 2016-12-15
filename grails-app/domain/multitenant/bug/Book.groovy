package multitenant.bug

import grails.gorm.MultiTenant
import grails.gorm.multitenancy.Tenants

class Book implements MultiTenant<Book> {

    String tenantId
    String title
    String author

    static constraints = {
        title blank: false
        author nullable: true
    }

    static mapping = {
    }

    static scaffold = [
            exclude: ['tenantId']
    ]

    def beforeValidate() {
        if (!tenantId) {
            this.setTenantId(Tenants.currentId())
        }
    }
}
