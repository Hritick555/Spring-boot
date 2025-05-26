package com.practice.cloudvendor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.practice.cloudvendor.model.CloudVendor;

/*
 @DataJpaTest
 to test the persistence layer of your application in isolation.
 It is ideal for testing repository methods, custom queries, and entity mappings.
 By default, it will use embedded database(H2). To use other databases ,Override @AutoConfigureTestDatabase(replace = Replace.NONE)
 */
@DataJpaTest 
public class CloudVendorRepositoryTest {

	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;

	@BeforeEach
	void setUp() {
		cloudVendor = new CloudVendor("123", "Amazon", "Address", "12345");
		cloudVendorRepository.save(cloudVendor);
	}

	@AfterEach
	void tearDown() {
		cloudVendor = null;
		cloudVendorRepository.deleteAll();
	}

	@Test
	void testFoundByVendorName_Found() {
		List<CloudVendor> vendor = cloudVendorRepository.findByVendorPhone("12345");
		// assertThat(vendor.isEmpty()).isFalse();
		assertThat(vendor.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
		assertThat(vendor.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
		assertThat(vendor.get(0).getVendorName()).isEqualTo(cloudVendor.getVendorName());

	}

	@Test
	void testFoundByVendorName_NotFound() {
		List<CloudVendor> vendor = cloudVendorRepository.findByVendorPhone("123");
		assertThat(vendor.isEmpty()).isTrue();
	}
}

/*
 * The @SpringBootTest and @DataJpaTest annotations in Spring Boot serve
 * different purposes and are used in different testing scenarios. Here's a
 * detailed comparison between the two:
 * 
 * 1. Purpose ------------
 * 
 * @SpringBootTest:
 * 
 * Used for integration testing where the full application context is loaded.
 * 
 * It starts the entire Spring application, including all configurations, beans,
 * and layers (e.g., controllers, services, repositories).
 * 
 * Ideal for testing the application as a whole or interactions between multiple
 * layers.
 * 
 * @DataJpaTest:
 * 
 * Used for sliced testing of the JPA (persistence) layer.
 * 
 * It only loads the parts of the application context required for JPA testing,
 * such as EntityManager, DataSource, and JPA repositories.
 * 
 * Ideal for testing repository methods, entity mappings, and database
 * interactions in isolation.
 * __________________________________________________________________________________________________________________________________
 * 2. Scope ---------
 * 
 * @SpringBootTest:
 * 
 * Loads the full application context.
 * 
 * Includes all beans (e.g., controllers, services, repositories,
 * configurations).
 * 
 * Can be used to test the entire application or specific components in a full
 * context.
 * 
 * @DataJpaTest:
 * 
 * Loads a limited application context.
 * 
 * Focuses only on JPA-related components (e.g., EntityManager, DataSource,
 * repositories).
 * 
 * Excludes other parts of the application, such as controllers and services.
 * _________________________________________________________________________________________________________________________
 * 3. Database Configuration -------------------------
 * 
 * @SpringBootTest:
 * 
 * Uses the database configured in the application properties (e.g.,
 * application.properties or application.yml).
 * 
 * Can connect to a real database or an embedded database, depending on the
 * configuration.
 * 
 * Suitable for end-to-end testing with the actual database.
 * 
 * @DataJpaTest:
 * 
 * By default, configures an embedded in-memory database (e.g., H2) for testing.
 * 
 * You can override this behavior to use a real database by
 * adding @AutoConfigureTestDatabase(replace = Replace.NONE). --------------
 * ---------------------------------------------------- Focuses on testing the
 * persistence layer without affecting the rest of the application.
 * ______________________________________________________________________________________________________________________________
 * 4. Performance -----------------
 * 
 * @SpringBootTest:
 * 
 * Slower because it loads the full application context.
 * 
 * Suitable for integration tests but may be overkill for testing specific
 * layers.
 * 
 * @DataJpaTest:
 * 
 * Faster because it loads only the JPA-related components.
 * 
 * Ideal for focused testing of the persistence layer.
 * __________________________________________________________________________________________________________________________________
 * 5. Use Cases --------------
 * 
 * @SpringBootTest:
 * 
 * Testing the entire application (end-to-end tests).
 * 
 * Testing interactions between multiple layers (e.g., controller → service →
 * repository).
 * 
 * Testing with the actual production-like environment.
 * 
 * @DataJpaTest:
 * 
 * Testing repository methods and custom queries.
 * 
 * Testing entity mappings and database interactions.
 * 
 * Testing the persistence layer in isolation.
 * __________________________________________________________________________________________________________________________________
 * 6. Annotations and Configuration ---------------------------------
 * 
 * @SpringBootTest:
 * 
 * Often used with other annotations like @MockBean, @SpyBean,
 * or @TestConfiguration to customize the test context.
 * 
 * Can be configured to start the application with a specific environment (e.g.,
 * webEnvironment = WebEnvironment.RANDOM_PORT).
 * 
 * @DataJpaTest:
 * 
 * Often used with @AutoConfigureTestDatabase to control the database
 * configuration.
 * 
 * Provides access to TestEntityManager for managing entities during tests.
 */