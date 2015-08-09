/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.nbmindmap.mmgui;

import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.Assert.*;
import org.junit.Test;

public class ConfigurationTest {
  
  @Test
  public void testMakeFullCopyOf(){
    final Configuration dst = new Configuration();
    final Configuration src = new Configuration();
    
    assertTrue(dst.isDropShadow());
    assertTrue(dst.isDrawBackground());
    
    src.setDrawBackground(false);
    src.setDropShadow(false);

    final AtomicInteger callCounter = new AtomicInteger();
    
    final Configuration.ConfigurationListener lstnr = new Configuration.ConfigurationListener() {
      
      @Override
      public void onConfigurationPropertyChanged(Configuration source) {
        callCounter.incrementAndGet();
      }
    };
    
    src.addConfigurationListener(lstnr);
    
    
    dst.makeFullCopyOf(src, true, true);
    
    assertFalse(dst.isDropShadow());
    assertFalse(dst.isDrawBackground());
    assertEquals(1,callCounter.get());
  }
  
}