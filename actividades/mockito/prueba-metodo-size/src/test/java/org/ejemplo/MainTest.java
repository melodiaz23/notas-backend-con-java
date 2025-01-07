package org.ejemplo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MainTest {

  @Test
  void testMain() {
  }

    @Test
    void shouldAnswerWithTrue() {
      assertTrue(true);
    }


    @Test
    void createMockObject(){
      List<Integer> numeros = mock(List.class);
      Integer size = numeros.size();
      assertEquals(0, size);
    }

    @Test
    void createMockObject2(){
      List<Integer> numeros = mock(List.class);
      when(numeros.size()).thenReturn(1);
      Integer size = numeros.size();
      assertEquals(1, size);
    }

  @Test
  void createMockObject3() {
    List<Integer> numeros = mock(List.class);
    numeros.add(1);
    verify(numeros, atLeast(1)).add(1);
  }


  @Test
    public void createSpyObject() {
      List<Integer> numeros = spy(new ArrayList<>());
      numeros.add(5);
      verify(numeros, atLeast(1)).add(5);
      assertEquals(1, numeros.size());
    }
  }


