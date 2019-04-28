package shiro.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class springboot {


    @Autowired
    DataSource source;

    @Test
    public void conextLoad() throws SQLException {
        System.out.println(source.getClass());
        Connection connection = source.getConnection();
        ;
        System.out.println(connection);
        connection.close();
    }

}
