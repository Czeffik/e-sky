import com.github.javafaker.Faker
import com.github.javafaker.Internet
import dataProviders.ValidationMessages
import geb.spock.GebReportingSpec
import jodd.util.RandomString
import pages.loginAndCreatingAccount.CreateAccountPage
import spock.lang.Shared
import spock.lang.Unroll

class CreateAccountSpec extends GebReportingSpec {
    @Shared
    Internet faker = new Faker().internet()
    @Shared
    ValidationMessages msg = new ValidationMessages()
    @Shared
    RandomString random = new RandomString()

    def setup() {
        to CreateAccountPage
    }

    @Unroll
    def 'Should not create account with email: #email, accept terms: #acceptTerms, because: #validationMessage'() {
        when:
        if (secondPassword != '') {
            createAccountModule.fillFieldsAncClickButton(email, firstPassword, secondPassword, acceptTerms)
        } else {
            createAccountModule.fillFieldsAncClickButton(email, firstPassword, acceptTerms)
        }

        then:
        at CreateAccountPage
        validationMessage in createAccountModule.userRegistration.errorMessage.collect { it -> it.text() }

        where:
        email                                                                        || firstPassword           || secondPassword   || acceptTerms || validationMessage
        faker.emailAddress()                                                         || faker.password()        || faker.password() || true        || msg.differentPasswords
        faker.emailAddress()                                                         || faker.password(1, 5)    || ''               || true        || msg.passwordToShort
        faker.emailAddress()                                                         || faker.password()        || ''               || false       || msg.acceptTerms
        ''                                                                           || faker.password()        || ''               || true        || msg.emptyEmailCreatingAccount
        faker.emailAddress()                                                         || random.randomAlpha(121) || ''               || true        || msg.passwordToLong
        random.randomAlpha(10)                                                       || faker.password()        || ''               || true        || msg.invalidEmailCreatingAccount
        "@${random.randomAlpha(5)}.${random.randomAlpha(5)}"                         || faker.password()        || ''               || true        || msg.invalidEmailCreatingAccount
        "${random.randomAlpha(5)}@${random.randomAlpha(5)}."                         || faker.password()        || ''               || true        || msg.invalidEmailCreatingAccount
        "${random.randomAlpha(5)}@${random.randomAlpha(5)}.${random.randomAlpha(1)}" || faker.password()        || ''               || true        || msg.invalidEmailCreatingAccount
    }

}
