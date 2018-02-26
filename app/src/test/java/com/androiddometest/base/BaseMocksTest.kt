package com.androiddometest.base

import org.junit.Before
import org.mockito.MockitoAnnotations


/**
 *
 * @author zhouyong
 * @date 2018-01-25 14:09
 * @version V 1.0
 */
open class BaseMocksTest {
    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
}