/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.visitor.impl;

import org.apache.shardingsphere.sql.parser.visitor.OracleVisitor;

/**
 * Oracle DDL visitor.
 *
 * @author zhangliang
 */
public final class OracleDDLVisitor extends OracleVisitor {
    
//    @Override
//    public ASTNode visitCreateTable(final CreateTableContext ctx) {
//        CreateTableStatement result = new CreateTableStatement();
//        TableSegment table = (TableSegment) visit(ctx.tableName());
//        result.getTables().add(table);
//        result.getAllSQLSegments().add(table);
//        if (null != ctx.createDefinitionClause()) {
//            CreateTableStatement createDefinition = (CreateTableStatement) visit(ctx.createDefinitionClause());
//            result.getColumnDefinitions().addAll(createDefinition.getColumnDefinitions());
//            for (SQLSegment each : createDefinition.getAllSQLSegments()) {
//                result.getAllSQLSegments().add(each);
//                if (each instanceof TableSegment) {
//                    result.getTables().add((TableSegment) each);
//                }
//            }
//        }
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitCreateDefinitionClause(final CreateDefinitionClauseContext ctx) {
//        CreateTableStatement result = new CreateTableStatement();
//        for (CreateDefinitionContext each : ctx.createDefinition()) {
//            ColumnDefinitionContext columnDefinition = each.columnDefinition();
//            if (null != columnDefinition) {
//                result.getColumnDefinitions().add((ColumnDefinitionSegment) visit(columnDefinition));
//                result.getAllSQLSegments().addAll(getTableSegments(columnDefinition));
//            }
//            if (null != each.tableConstraint() && null != each.tableConstraint().tableConstraintOption().tableName()) {
//                result.getAllSQLSegments().add((TableSegment) visit(each.tableConstraint().tableConstraintOption().tableName()));
//            }
//        }
//        if (result.getColumnDefinitions().isEmpty()) {
//            result.getAllSQLSegments().addAll(result.getColumnDefinitions());
//        }
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitAlterTable(final AlterTableContext ctx) {
//        AlterTableStatement result = new AlterTableStatement();
//        TableSegment table = (TableSegment) visit(ctx.tableNameClause());
//        result.getTables().add(table);
//        result.getAllSQLSegments().add(table);
//        if (null != ctx.alterDefinitionClause()) {
//            AlterTableStatement alterDefinition = (AlterTableStatement) visit(ctx.alterDefinitionClause());
//            result.getAddedColumnDefinitions().addAll(alterDefinition.getAddedColumnDefinitions());
//            result.getChangedPositionColumns().addAll(alterDefinition.getChangedPositionColumns());
//            result.getDroppedColumnNames().addAll(alterDefinition.getDroppedColumnNames());
//            for (SQLSegment each : alterDefinition.getAllSQLSegments()) {
//                result.getAllSQLSegments().add(each);
//                if (each instanceof TableSegment) {
//                    result.getTables().add((TableSegment) each);
//                }
//            }
//        }
//        return result;
//    }
//    
//    @SuppressWarnings("unchecked")
//    @Override
//    public ASTNode visitAlterDefinitionClause(final AlterDefinitionClauseContext ctx) {
//        final AlterTableStatement result = new AlterTableStatement();
//        if (null != ctx.alterTableActions()) {
//            for (AlterTableActionContext each : ctx.alterTableActions().alterTableAction()) {
//                AddColumnSpecificationContext addColumnSpecification = each.addColumnSpecification();
//                if (null != addColumnSpecification) {
//                    CollectionValue<AddColumnDefinitionSegment> addColumnDefinitions = (CollectionValue<AddColumnDefinitionSegment>) visit(addColumnSpecification);
//                    for (AddColumnDefinitionSegment addColumnDefinition : addColumnDefinitions.getValue()) {
//                        result.getAddedColumnDefinitions().add(addColumnDefinition.getColumnDefinition());
//                        Optional<ColumnPositionSegment> columnPositionSegment = addColumnDefinition.getColumnPosition();
//                        // TODO refactor SQLStatement
//                        // CHECKSTYLE:OFF
//                        if (columnPositionSegment.isPresent()) {
//                            result.getChangedPositionColumns().add(columnPositionSegment.get());
//                        }
//                        // CHECKSTYLE:ON
//                    }
//                    result.getAllSQLSegments().addAll(getTableSegments(addColumnSpecification.columnDefinition()));
//                }
//                AddConstraintSpecificationContext addConstraintSpecification = each.addConstraintSpecification();
//                TableConstraintOptionContext tableConstraintOption = null == addConstraintSpecification || null == addConstraintSpecification.tableConstraint()
//                        ? null : addConstraintSpecification.tableConstraint().tableConstraintOption();
//                if (null != tableConstraintOption && null != tableConstraintOption.tableName()) {
//                    result.getAllSQLSegments().add((TableSegment) visit(tableConstraintOption.tableName()));
//                }
//                ModifyColumnSpecificationContext modifyColumnSpecification = each.modifyColumnSpecification();
//                if (null != modifyColumnSpecification) {
//                    Optional<ColumnPositionSegment> columnPositionSegment = ((ModifyColumnDefinitionSegment) visit(modifyColumnSpecification)).getColumnPosition();
//                    // TODO refactor SQLStatement
//                    // CHECKSTYLE:OFF
//                    if (columnPositionSegment.isPresent()) {
//                        result.getChangedPositionColumns().add(columnPositionSegment.get());
//                    }
//                    // CHECKSTYLE:ON
//                }
//                DropColumnSpecificationContext dropColumnSpecification = each.dropColumnSpecification();
//                if (null != dropColumnSpecification) {
//                    result.getDroppedColumnNames().add(((DropColumnDefinitionSegment) visit(dropColumnSpecification)).getColumnName());
//                }
//            }
//        }
//        if (result.getAddedColumnDefinitions().isEmpty()) {
//            result.getAllSQLSegments().addAll(result.getAddedColumnDefinitions());
//        }
//        if (result.getChangedPositionColumns().isEmpty()) {
//            result.getAllSQLSegments().addAll(result.getChangedPositionColumns());
//        }
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitAddColumnSpecification(final AddColumnSpecificationContext ctx) {
//        CollectionValue<AddColumnDefinitionSegment> result = new CollectionValue<>();
//        ColumnDefinitionContext columnDefinition = ctx.columnDefinition();
//        if (null != columnDefinition) {
//            AddColumnDefinitionSegment addColumnDefinition = new AddColumnDefinitionSegment(
//                    ctx.columnDefinition().getStart().getStartIndex(), columnDefinition.getStop().getStopIndex(), (ColumnDefinitionSegment) visit(columnDefinition));
//            result.getValue().add(addColumnDefinition);
//        }
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitColumnDefinition(final ColumnDefinitionContext ctx) {
//        ColumnSegment column = (ColumnSegment) visit(ctx.columnName());
//        IdentifierValue dataType = (IdentifierValue) visit(ctx.dataType().dataTypeName());
//        boolean isPrimaryKey = containsPrimaryKey(ctx);
//        return new ColumnDefinitionSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), column.getIdentifier().getValue(), dataType.getValue(), isPrimaryKey);
//    }
//    
//    private boolean containsPrimaryKey(final ColumnDefinitionContext ctx) {
//        for (ColumnConstraintContext each : ctx.columnConstraint()) {
//            if (null != each.columnConstraintOption() && null != each.columnConstraintOption().primaryKey()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    @Override
//    public ASTNode visitModifyColumnSpecification(final ModifyColumnSpecificationContext ctx) {
//        // TODO visit column definition, need to change g4 for modifyColumn
//        return new ModifyColumnDefinitionSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), null);
//    }
//    
//    @Override
//    public ASTNode visitDropColumnSpecification(final DropColumnSpecificationContext ctx) {
//        return new DropColumnDefinitionSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(),
//                ((ColumnSegment) visit(ctx.columnName())).getIdentifier().getValue());
//    }
//    
//    @Override
//    public ASTNode visitRenameColumnSpecification(final RenameColumnSpecificationContext ctx) {
//        return new RenameColumnSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(),
//                ((ColumnSegment) visit(ctx.columnName(0))).getIdentifier().getValue(), ((ColumnSegment) visit(ctx.columnName(1))).getIdentifier().getValue());
//    }
//    
//    private Collection<TableSegment> getTableSegments(final ColumnDefinitionContext columnDefinition) {
//        Collection<TableSegment> result = new LinkedList<>();
//        for (ColumnConstraintContext each : columnDefinition.columnConstraint()) {
//            if (null != each.columnConstraintOption().tableName()) {
//                result.add((TableSegment) visit(each.columnConstraintOption().tableName()));
//            }
//        }
//        return result;
//    }
//    
//    @SuppressWarnings("unchecked")
//    @Override
//    public ASTNode visitDropTable(final DropTableContext ctx) {
//        DropTableStatement result = new DropTableStatement();
//        CollectionValue<TableSegment> tables = (CollectionValue<TableSegment>) visit(ctx.tableNames());
//        result.getTables().addAll(tables.getValue());
//        result.getAllSQLSegments().addAll(tables.getValue());
//        return result;
//    }
//    
//    @SuppressWarnings("unchecked")
//    @Override
//    public ASTNode visitTruncateTable(final TruncateTableContext ctx) {
//        TruncateStatement result = new TruncateStatement();
//        CollectionValue<TableSegment> tables = (CollectionValue<TableSegment>) visit(ctx.tableNamesClause());
//        result.getTables().addAll(tables.getValue());
//        result.getAllSQLSegments().addAll(tables.getValue());
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitCreateIndex(final CreateIndexContext ctx) {
//        CreateIndexStatement result = new CreateIndexStatement();
//        TableSegment table = (TableSegment) visit(ctx.tableName());
//        result.setTable(table);
//        result.getAllSQLSegments().add(table);
//        return result;
//    }
//    
//    @Override
//    public ASTNode visitDropIndex(final DropIndexContext ctx) {
//        return new DropIndexStatement();
//    }
//    
//    @Override
//    public ASTNode visitTableNameClause(final TableNameClauseContext ctx) {
//        return visit(ctx.tableName());
//    }
//    
//    @Override
//    public ASTNode visitTableNamesClause(final TableNamesClauseContext ctx) {
//        Collection<TableSegment> tableSegments = new LinkedList<>();
//        for (int i = 0; i < ctx.tableNameClause().size(); i++) {
//            tableSegments.add((TableSegment) visit(ctx.tableNameClause(i)));
//        }
//        CollectionValue<TableSegment> result = new CollectionValue<>();
//        result.getValue().addAll(tableSegments);
//        return result;
//    }
}
