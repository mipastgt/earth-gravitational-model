/*
* Copyright (C) Sean J. Barbeau (sjbarbeau@gmail.com)
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
package com.barbeaudev.geotools.referencing.operation.transform.test;

import com.barbeaudev.geotools.referencing.operation.transform.EarthGravitationalModel;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Tests for EarthGravitationalModel to calculate mean sea level altitude from WGS84 altitude
 */
public class EarthGravitationalModelTest extends TestCase {

    static final double EPSILON = 0.001;

    @Test
    public void testEGM() throws Exception {
        final EarthGravitationalModel gh = new EarthGravitationalModel();
        gh.load("/egm180.nor");

        // From GeoTools EGM unit test
        assertEquals(1.505, gh.heightOffset(45, 45, 0), EPSILON);
        assertEquals(1.515, gh.heightOffset(45, 45, 1000), EPSILON);
        assertEquals(46.908, gh.heightOffset(0, 45, 0), EPSILON);

        // From https://github.com/matthiaszimmermann/EGM96/blob/master/src/test/java/org/matthiaszimmermann/location/egm96/GeoidTest.java#L145
        assertEquals(13.89, gh.heightOffset(89.74, 5.75, 0), EPSILON);
        assertEquals(11.76, gh.heightOffset(86.5, 217.25, 0), EPSILON);
        assertEquals(43.56, gh.heightOffset(71.25, 8.0, 0), EPSILON);
        assertEquals(2.35, gh.heightOffset(54.0, 182.25, 0), EPSILON);
        assertEquals(-12.91, gh.heightOffset(35.5, 186.0, 0), EPSILON);
        assertEquals(-8.07, gh.heightOffset(14.75, 213.5, 0), EPSILON);
        assertEquals(-10.18, gh.heightOffset(-22.25, 221.5, 0), EPSILON);
        assertEquals(25.61, gh.heightOffset(-37.5, 13.0, 0), EPSILON);
        assertEquals(-17.88, gh.heightOffset(-51.75, 157.25, 0), EPSILON);
        assertEquals(5.18, gh.heightOffset(-70.5, 346.0, 0), EPSILON);
        assertEquals(17.5, gh.heightOffset(-74.5, 22.0, 0), EPSILON);
        assertEquals(-25.71, gh.heightOffset(-84.5, 306.25, 0), EPSILON);
        assertEquals(-21.81, gh.heightOffset(-86.75, 328.75, 0), EPSILON);
        assertEquals(-29.79, gh.heightOffset(-90.0, 0.0, 0), EPSILON);
    }
}
