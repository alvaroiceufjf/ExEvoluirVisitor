package testin;



import com.mycompany.exevoluirjson.Aluno;
import com.mycompany.exevoluirjson.Curso;
import com.mycompany.exevoluirjson.Funcionario;
import com.mycompany.exevoluirjson.Pessoa;
import com.mycompany.exevoluirjson.PessoaVisitorJSON;
import com.mycompany.exevoluirjson.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorJSONTest {

    private PessoaVisitorJSON visitor;

    @BeforeEach
    public void setUp() {
        visitor = new PessoaVisitorJSON();
    }

    @Test
    public void testExibirAluno() {
        Curso curso = new Curso("Engenharia de Software");
        Aluno aluno = new Aluno(123, "João Silva", curso);
        String jsonEsperado = "{\"matricula\":123,\"nome\":\"João Silva\",\"curso\":\"Engenharia de Software\"}";

        String jsonResultado = visitor.exibirAluno(aluno);

        assertEquals(jsonEsperado, jsonResultado);
    }

    @Test
    public void testExibirProfessor() {
        Professor professor = new Professor(456, "Dra. Maria Santos", "Doutorado");
        String jsonEsperado = "{\"matricula\":456,\"nome\":\"Dra. Maria Santos\",\"titulacao\":\"Doutorado\"}";

        String jsonResultado = visitor.exibirProfessor(professor);

        assertEquals(jsonEsperado, jsonResultado);
    }

    @Test
    public void testExibirFuncionario() {
        Funcionario funcionario = new Funcionario(789, "Carlos Souza", (float) 3500.50);
        String jsonEsperado = "{\"codigo\":789,\"nome\":\"Carlos Souza\",\"salario\":3500.5}";

        String jsonResultado = visitor.exibirFuncionario(funcionario);

        assertEquals(jsonEsperado, jsonResultado);
    }

    @Test
    public void testExibirMetodoGeralPessoa() {
        Curso curso = new Curso("Engenharia de Software");
        Pessoa pessoa = new Aluno(123, "João Silva", curso);
        String jsonEsperado = "{\"matricula\":123,\"nome\":\"João Silva\",\"curso\":\"Engenharia de Software\"}";

        String jsonResultado = visitor.exibir(pessoa);

        assertEquals(jsonEsperado, jsonResultado);
    }
}