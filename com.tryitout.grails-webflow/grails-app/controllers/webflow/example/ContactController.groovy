package webflow.example

class ContactController {
    def scaffold = true

    def transient sessionFactory

    def buildFlow = {
        enter {
            action {
//                Contact flow.contact = new Contact()
//                [contact: flow.contact]
                Contact contact = new Contact()
                [contact: contact]
            }
            on("success").to("name")
            on(Exception).to("error")
        }
        name {
            on('next') { BuildContactNameCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command
                    return error()
                }
                bindData(flow.contact, command)
                [contact: flow.contact]
            }.to('address')
            on('cancel').to('finish')
        }
        address {
            on('next') { BuildContactAddressCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command
                    return error()
                }
                bindData(flow.contact, command)
                [contact: flow.contact]
            }.to('electronic')
            on('previous').to('name')
            on('cancel').to('finish')
        }
        electronic {
            on('next') { BuildContactElectronicCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command
                    return error()
                }
                bindData(flow.contact, command)
                [contact: flow.contact]
            }.to('complete')
            on('previous').to('address')
            on('cancel').to('finish')
        }
        complete {
            on('next') {
                if (!flow.contact.save()) {
                    flash.message = "Couldn't save the contact"
                    return error()
                }
            }.to('finish')
            on('previous').to('electronic')
            on('cancel').to('finish')
            on(Exception).to('error')
        }
        error {
            on('confirm').to('finish')
        }
        finish {
            redirect(controller: 'contact', action: 'list')
        }
    }

}

class BuildContactNameCommand implements Serializable {
    String firstName
    String lastName

    static constraints = {
        firstName(blank: false, nullable: false, maxSize: 50)
        lastName(blank: false, nullable: false, maxSize: 50)
    }

}

class BuildContactAddressCommand implements Serializable {
    String address1
    String address2
    String city
    String state
    String zip

    static constraints = {
        address1(blank: false, nullable: false, maxSize: 50)
        address2(blank: true, nullable: true)
        city(blank: false, nullable: false, maxSize: 50)
        state(blank: false, nullable: false, maxSize: 2)
        zip(blank: false, nullable: false, maxSize: 10)
    }

}

class BuildContactElectronicCommand implements Serializable {
    String phone
    String email

    static constraints = {
        phone(blank: false, nullable: false, maxSize: 15)
        email(blank: false, nullable: false, maxSize: 50)
    }

}