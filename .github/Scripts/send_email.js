const nodemailer = require('nodemailer');

async function enviarEmail() {
    const remetente = process.env.EMAIL_EDUARDO;
    const senha = process.env.SENHA_PRA_EMAIL;
    const destinatario = remetente; // Enviar para o próprio remetente
    const assunto = 'Notificação Automática do GitHub Actions (JS)';
    const corpo = 'Este é um e-mail de teste enviado automaticamente via GitHub Actions usando JavaScript.';

    if (!remetente || !senha) {
        console.error('Erro: Variáveis de ambiente EMAIL_EDUARDO ou SENHA_PRA_EMAIL não configuradas.');
        process.exit(1);
    }

    let transporter = nodemailer.createTransport({
        host: 'smtp.gmail.com',
        port: 465,
        secure: true, // true for 465, false for other ports
        auth: {
            user: remetente,
            pass: senha,
        },
    });

    let info = await transporter.sendMail({
        from: `"GitHub Actions" <${remetente}>`,
        to: destinatario,
        subject: assunto,
        text: corpo,
        html: `<p>${corpo}</p>`,
    });

    console.log('E-mail enviado com sucesso: %s', info.messageId);
}

enviarEmail().catch(console.error);

