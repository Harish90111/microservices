package com.harish.rentcar.demoapplication;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="stage")
public class StageEndPoint {

  Map<String, Stage> stages = new ConcurrentHashMap<>();

  @ReadOperation
  public Map<String, Stage> getAllStages() {
    return stages;
  }

  @ReadOperation
  public Stage getStages(@Selector String name) {
    return stages.get(name);
  }

  //Can't pass complex datatypes e.g. stage object as input.
  //http://localhost:8080/actuator/stage/st0001

  @WriteOperation
  public void setValue(@Selector String name, int stage){
    stages.put(name, new Stage(stage));
  }

  static class Stage{
    int value;
    public Stage(int value) {
      this.value = value;
    }

    public void setValue(int value) {
      this.value = value;
    }
    public int getValue() {
      return value;
    }
  }
}
