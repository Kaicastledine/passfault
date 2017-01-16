/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.owasp.passfault.finders;

import org.junit.Test;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import static org.junit.Assert.assertEquals;

public class DateFinderTest {
  PatternFinder finder = new DateFinder(TestingPatternCollectionFactory.getInstance());
  
  @Test
  public void testAnalyze() throws Exception {
    assertEquals(1, finder.search("12-25-1999").getCount());
    assertEquals(1, finder.search("12-25-99").getCount());
    assertEquals(1, finder.search("04-06-1976").getCount());
    assertEquals(1, finder.search("122599").getCount());
    assertEquals(1, finder.search("2001-12-25").getCount());
    assertEquals(1, finder.search("1776-06-04").getCount());
  }

  @Test(timeout = 500) //This better execute in under 1/2 seconds
  public void testStress() throws Exception {
    for (int i = 0; i < 100000; i++) {
      finder.search("1776-06-04");
    }
  }
}
