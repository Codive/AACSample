package info.codive.template.acc

import android.content.Context
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import info.codive.template.acc.model.data.SampleEntity
import info.codive.template.acc.model.database.SampleDatabase
import info.codive.template.acc.model.database.SampleTableDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

// @RunWith(AndroidJUnit4::class)
class SampleDatabaseTest {

    private lateinit var sampleTableDao: SampleTableDao
    private lateinit var db: SampleDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SampleDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        sampleTableDao = db.sampleTableDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetSampleEntity() {
        val sampleEntity = SampleEntity()
        val inserted = sampleTableDao.insert(sampleEntity)
        assertEquals(1, inserted)

        val sample = sampleTableDao.get(1)
        assertEquals("sample", sample?.message)

        val count = sampleTableDao.count()
        assertEquals(1, count)

        val list = sampleTableDao.getAll()
        assertEquals(1, list.size)
    }
}


