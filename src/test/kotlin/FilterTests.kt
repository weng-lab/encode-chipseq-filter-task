import org.junit.jupiter.api.*
import step.*
import testutil.*
import testutil.cmdRunner
import testutil.setupTest
import util.*
import org.assertj.core.api.Assertions.*

class FilterTests {
    @BeforeEach fun setup() = setupTest()
  //  @AfterEach fun cleanup() = cleanupTest()// CopyOpt()

     @Test fun `run filter step - pairedend nodupRemoval`() {

        cmdRunner.filter(PBAM,null,DupMarker.picard,30,true,true,1,1,"chrM", testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.filt.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.bam.bai")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.flagstat.qc")).exists()
    }
    @Test fun `run filter step- pairedend dupRemoval`() {

        cmdRunner.filter(PBAM,null,DupMarker.picard,30,true,false,0,1,"chrM", testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.mito_dup.txt")).exists()
        assertThat( testOutputDir.resolve("filteroutput.dup.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.pbc.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.flagstat.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam.bai")).exists()
    }
     @Test fun `run filter step - dupRemoval `() {


        cmdRunner.filter(BAM,null,DupMarker.picard,30,false,false,0,1, "chrM",testOutputDir.resolve("filteroutput"))
         assertThat( testOutputDir.resolve("filteroutput.nodup.bam")).exists()
         assertThat( testOutputDir.resolve("filteroutput.mito_dup.txt")).exists()
         assertThat( testOutputDir.resolve("filteroutput.dup.qc")).exists()
         assertThat( testOutputDir.resolve("filteroutput.pbc.qc")).exists()
         assertThat( testOutputDir.resolve("filteroutput.nodup.flagstat.qc")).exists()
         assertThat( testOutputDir.resolve("filteroutput.nodup.bam.bai")).exists()
    }

    @Test fun `run filter step-  nodupRemoval`() {

        cmdRunner.filter(BAM,null,DupMarker.picard,30,false,true,0,1, "chrM",testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.filt.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.bam.bai")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.flagstat.qc")).exists()
    }
    @Test fun `run filter step - sambamba pairedend nodupRemoval`() {

        cmdRunner.filter(PBAM,null,DupMarker.sambamba,30,true,true,1,1, "chrM",testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.filt.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.bam.bai")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.flagstat.qc")).exists()
    }
     @Test fun `run filter step- sambamba pairedend dupRemoval`() {

        cmdRunner.filter(PBAM,sponge,DupMarker.sambamba,30,true,false,0,1,"chrM", testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.mito_dup.txt")).exists()
        assertThat( testOutputDir.resolve("filteroutput.dup.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.pbc.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.flagstat.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam.bai")).exists()
    }
     @Test fun `run filter step - sambamba nodupRemoval`() {


        cmdRunner.filter(BAM,null,DupMarker.sambamba,30,false,true,0,1, "chrM",testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.filt.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.bam.bai")).exists()
        assertThat( testOutputDir.resolve("filteroutput.filt.flagstat.qc")).exists()
    }
     @Test fun `run filter step-  sambamba dupRemoval`() {

        cmdRunner.filter(BAM,null,DupMarker.sambamba,30,false,false,0,1,"chrM", testOutputDir.resolve("filteroutput"))
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam")).exists()
        assertThat( testOutputDir.resolve("filteroutput.mito_dup.txt")).exists()
        assertThat( testOutputDir.resolve("filteroutput.dup.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.pbc.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.flagstat.qc")).exists()
        assertThat( testOutputDir.resolve("filteroutput.nodup.bam.bai")).exists()
    }
}