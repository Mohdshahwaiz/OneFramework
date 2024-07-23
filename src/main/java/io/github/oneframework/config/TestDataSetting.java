

package io.github.oneframework.config;

import io.github.oneframework.enums.TestDataSource;
import lombok.Data;

/**
 * Test Data Setting.
 *
 * @author Rahul Rana
 * @since 18-Nov-2023
 */
@Data
public class TestDataSetting {
    private String         extension = "xlsx";
    private boolean        external;
    private String         path = "test-data";
    private TestDataSource type = TestDataSource.EXCEL;
}
