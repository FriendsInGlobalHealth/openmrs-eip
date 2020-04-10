package org.openmrs.utils.odoo.workordermanager.rule;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openmrs.utils.odoo.exception.OdooException;
import org.openmrs.utils.odoo.workordermanager.WorkOrderStatusTransitionContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class FailureRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    class FailOrPassRule extends FailureRule {
        boolean pass;

        public FailOrPassRule(boolean pass) {
            this.pass = pass;
        }

        @Override
        boolean fail(WorkOrderStatusTransitionContext context) {
            return pass;
        }
    }

    @Test
    public void workOrderMatchesCondition_shouldFailIfTheRulePasses() {
        final int sequence = 5;
        expectedException.expect(OdooException.class);
        expectedException.expectMessage(CoreMatchers.equalTo("Can't process work order with sequence number: " + sequence));

        new FailOrPassRule(true).workOrderMatchesCondition(new WorkOrderStatusTransitionContext(null, 0, sequence));
    }

    @Test
    public void workOrderMatchesCondition_shouldReturnFalseIfTheRuleFails() {
        assertFalse(new FailOrPassRule(false).workOrderMatchesCondition(new WorkOrderStatusTransitionContext(null, 0, 1)));
    }

    @Test
    public void getAction_shouldAlwaysReturnNull() {
        WorkOrderStatusTransitionContext context = new WorkOrderStatusTransitionContext(null, 0, 1);
        assertNull(new FailOrPassRule(false).getAction(context));
        assertNull(new FailOrPassRule(true).getAction(context));
    }

}
