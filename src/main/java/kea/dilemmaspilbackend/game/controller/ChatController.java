package kea.dilemmaspilbackend.game.controller;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
class ChatController {

    @MessageExceptionHandler
    @SendTo("/topic/errors")
    public String handleException(IllegalArgumentException e) {
        var message = ("an exception occurred! " + NestedExceptionUtils.getMostSpecificCause(e));
        System.out.println(message);
        return message;
    }


    @MessageMapping("/game/{lobby}")
    @SendTo("/topic/greetings/{lobby}")
    public Temp joinLobby(@DestinationVariable int lobby, Temp temp) throws Exception {
        Thread.sleep(1_000);

        temp.setLobbyID(lobby);

        return temp;
    }

}


class Temp{
    Temp(){

    }

    Temp(String name, int lobbyID){
        this.lobbyID = lobbyID;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLobbyID() {
        return lobbyID;
    }

    public void setLobbyID(int lobbyID) {
        this.lobbyID = lobbyID;
    }

    String name;
    Integer lobbyID;
}