package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ofPattern;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "rafael.lazzari@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(MAIL_TO);
        helper.setSubject("TESTE");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");

        File file1 = new File("imagem.jpg");

        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmailEndereco(PessoaDTO pessoaDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoaDTO.getEmail());
        message.setSubject("Endereco nao cadastrado");
        String texto = "Ola "+ pessoaDTO.getNome() + ",\n" +
                "\n" +
                "Estamos muito felizes que voc?? est?? em nosso sistema.\n" +
                "Para que possamos envi??-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endere??o no seu cadastro.\n" +
                "\n" +
                "Muito obrigado,\n" +
                "Sistema de Pessoas.\n";
        message.setText(texto);
        emailSender.send(message);
    }

    public void sendEmailAniversario(Pessoa pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoa.getEmail());
        message.setSubject("Feliz aniversario");
        String texto = "Ol?? "+pessoa.getNome()+",\n" +
                "\n" +
                "Essa data de "+pessoa.getDataNascimento().format(ofPattern("dd/MM"))+" tamb??m ?? especial para n??s do\n" +
                "Vem Ser. Estamos comemorando junto com voc??. lo/\n" +
                "\n" +
                "Desejamos um feliz anivers??rio, que sejam "+ (LocalDate.now().getYear() - pessoa.getDataNascimento().getYear()) +" anos de muitos. Sucesso, alegria,\n" +
                "felicidade e muitas realiza????es.\n" +
                "\n" +
                "Forte abra??o,\n" +
                "VemSerDBC |!";
        message.setText(texto);
        emailSender.send(message);
    }

    public void sendEmailPromocao(Pessoa pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoa.getEmail());
        message.setSubject("Promocao!!");
        String texto = "Ol?? "+pessoa.getNome()+",\n" +
                "\n" +
                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promo????o na nossa\n" +
                "plataforma especialmente para voc??:\n" +
                "\n" +
                "- Na compra de 1 CDs do Chit??ozinho e Xoror??, ganhe 1 do Milion??rio e Jos?? Rico.\n" +
                "- Na loca????o de um filme em VHS, a outra loca????o ?? gr??tis\n" +
                "- Fita de Super Nintendo com 50% de desconto.\n" +
                "\n" +
                "Aproveite!\n" +
                "Magazine OldSchool.\n" +
                "\n" +
                "??VEM SER\n" +
                "DBC";
        message.setText(texto);
        emailSender.send(message);
    }

    public void sendEmail(PessoaDTO pessoaDTO, String assunto,String templateName) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(geContentFromTemplate(pessoaDTO, templateName), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(PessoaDTO pessoaDTO, String templateName) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("suporte_email", from);
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        Template template = fmConfiguration.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
