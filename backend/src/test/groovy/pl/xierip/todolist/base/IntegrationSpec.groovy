package pl.xierip.todolist.base

import groovy.transform.TypeChecked
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import pl.xierip.todolist.todolist.TodoListApplication
import spock.lang.Specification

@TypeChecked
@SpringBootTest(classes = [TodoListApplication])
@ActiveProfiles(["test"])
@Transactional
@Rollback
abstract class IntegrationSpec extends Specification {
    @Autowired
    protected WebApplicationContext webApplicationContext;

    MockMvc mockMvc

    @Before
    void setupMock() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }
}
