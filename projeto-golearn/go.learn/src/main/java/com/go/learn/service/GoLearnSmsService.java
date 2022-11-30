package com.go.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.repository.GoLearnAlunoRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class GoLearnSmsService {

    @Autowired
    private GoLearnAlunoRepository goLearnAlunoRepository;

    public static final String ACCOUNT_SID = "AC159d9f5c00c2cd0321ebb08bfaeecba5";
    public static final String AUTH_TOKEN = "9812f85544b6c3bf58a2580552b9dced";

    public void enviarSms(Long idAluno){

        GoLearnAlunoModel goLearnAlunoModel = goLearnAlunoRepository.findById(idAluno).get();

        String msg = "O aluno "+goLearnAlunoModel.getNome() +" foi mátriculado com sucesso";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

             PhoneNumber to = new PhoneNumber("+5581985242579");
             PhoneNumber from = new PhoneNumber("+14246221967");

            Message message = Message.creator(to,from,msg).create();

            System.out.println(message.getSid());

    }


}