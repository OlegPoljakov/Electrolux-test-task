package Elctrlx.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DishWasherAPIController.class)
class StoveAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void createNewStove() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/stove/new?model=one");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Stove{id=1, model='one', state=Off, stoveTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void turnOnStove() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/stove/on?id=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Stove{id=1, model='one', state=On, stoveTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void turnOffStove() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/stove/off?id=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Stove{id=1, model='one', state=Off, stoveTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void setTemperatureStove() throws Exception {
        RequestBuilder requestToTurnOn = MockMvcRequestBuilders.get("/stove/on?id=1");
        RequestBuilder requestToSetTemp = MockMvcRequestBuilders.get("/stove/temp?id=1&temp=40");
        MvcResult result = mvc.perform(requestToSetTemp).andReturn();
        assertEquals("Stove{id=1, model='one', state=On, stoveTemperature=40}", result.getResponse().getContentAsString());
    }
}